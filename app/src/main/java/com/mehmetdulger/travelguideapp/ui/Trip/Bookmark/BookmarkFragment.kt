package com.mehmetdulger.travelguideapp.ui.Trip.Bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.adapters.trip.bookmark.BookmarkAdapter
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentBookmarkBinding
import com.mehmetdulger.travelguideapp.presentation.trip.bookmark.BookmarkViewModel

class BookmarkFragment : Fragment() {

    private lateinit var fragmentBookmarkBinding: FragmentBookmarkBinding
    private lateinit var searchViewModel: BookmarkViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()

    }

    private fun observeViewModel(){
        searchViewModel.uiModelBookmark.observe(viewLifecycleOwner) {
            renderBookmarkDestinationUi(it)
        }
        searchViewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(context,"Bir hata oluştu !", Toast.LENGTH_SHORT).show()
        }
    }
    private fun renderBookmarkDestinationUi(travelGuideModels: List<TravelGuideModel>){
        val adapter = BookmarkAdapter(travelGuideModels){ travelGuideModel ->
            navigateDetail(travelGuideModel)
        }
        fragmentBookmarkBinding.apply {
            setVariable(BR.travelGuideModel,adapter)
        }
    }




    private fun navigateDetail(travelGuideModel: TravelGuideModel){
        val action = BookmarkFragmentDirections.actionBookmarkFragmentToDetailFragment(currentAllData = travelGuideModel)
        findNavController().navigate(action)
    }


}