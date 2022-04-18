package com.assignment.restapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.assignment.restapi.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /*val view1=inflater.inflate(R.layout.fragment_second,container,false)
        val textviewSecond: TextView =view1.findViewById(R.id.textview_second)
        val textviewSecond1: TextView=view1.findViewById(R.id.textview_second1)
        val inputData: String? =arguments?.getString("data1")
        val inputData1:String?=arguments?.getString("data")
        textviewSecond.text = inputData1.toString()
        textviewSecond1.text= inputData.toString()
        val activity=context as AppCompatActivity
        Toast.makeText(activity,"$inputData", Toast.LENGTH_SHORT).show()*/
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textviewSecond: TextView =view.findViewById(R.id.textview_second)
        val textviewSecond1: TextView=view.findViewById(R.id.textview_second1)
        var inputData:String?=null
        var inputData1:String?=null
        inputData= arguments?.getString("data").toString()
        inputData1=arguments?.getString("data1").toString()
        //val inputData: String? =arguments?.getString("data1")
        //val inputData1:String?=arguments?.getString("data")
        if (inputData!=null){
            val activity=context as AppCompatActivity
            Toast.makeText(activity,"$inputData", Toast.LENGTH_SHORT).show()
        }
        textviewSecond.text = inputData
        textviewSecond1.text= inputData1
        //val activity=context as AppCompatActivity
        //Toast.makeText(activity,"$inputData", Toast.LENGTH_SHORT).show()
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}