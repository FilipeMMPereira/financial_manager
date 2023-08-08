package com.example.financialmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financialmanager.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemList = listOf(
            CashFlowItem("Produto 1", "$10"),
            CashFlowItem("Produto 2", "$20"),
            CashFlowItem("Produto 3", "$15"),
            CashFlowItem("Produto 4", "$40"),
            CashFlowItem("Produto 5", "$10"),
            CashFlowItem("Produto 6", "$20"),
            CashFlowItem("Produto 7", "$15"),
            CashFlowItem("Produto 8", "$40")
        )
        val adapter = CashFlowAdapter(itemList)
        binding.recycleViewCashFlow.layoutManager = LinearLayoutManager(requireContext())
        binding.recycleViewCashFlow.adapter = adapter
    }

}