package com.assignment.restapi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.restapi.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retro= Retrofit.Builder()
            .baseUrl(APIinterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val API=retro.create(APIinterface::class.java)
        val call=API.posts
        binding.recyclerview.layoutManager = LinearLayoutManager(view.context)
        call?.enqueue(object: Callback<List<PostModel?>?> {
            override fun onResponse(
                call: Call<List<PostModel?>?>,
                response: Response<List<PostModel?>?>
            ) {
                val postslist: List<PostModel>?= response.body() as List<PostModel>?
                val post= arrayOfNulls<String>(postslist!!.size)

                //in onCreate()
                //var recyclerView: RecyclerView = findViewById(R.id.recyclerview)
                var myAdapter = MyAdapter(postslist)
                //recyclerView.adapter=myAdapter
                binding.recyclerview.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<PostModel?>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure" + t.message)
            }

        })

        //binding.buttonFirst.setOnClickListener {
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        //}

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}