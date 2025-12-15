package demo.amjadkhan.livedatawithviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {
    private var currentName: MutableLiveData<String?>? = null
    fun getCurrentName(): MutableLiveData<String?> {
        if (currentName == null) {
            currentName = MutableLiveData<String?>()
        }
        return currentName!!
    } // Rest of the ViewModel...
}