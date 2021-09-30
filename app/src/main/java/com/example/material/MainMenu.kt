package com.example.material

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.example.material.databinding.MainMenuBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// Это полноценное активити, но это BottomSheetDialogFragment (Фрагмент)
class MainMenu : BottomSheetDialogFragment() {

    private var binding: MainMenuBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_menu, container, false)

        // Прослушиватель табов в Bottom Dialog Sheet Menu
        binding?.navigationView?.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.homeMenu -> {
                    val startHome = Intent(context, MainActivity::class.java)
                    val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((context as FragmentActivity))
                    startActivity(startHome, activityOptionsCompat.toBundle())
                }

                R.id.shopMenu -> {
                    //(context as FragmentActivity) нужен потому, что просто СаппортФрагментМенеджер работает только из полноценного Активити
                    (context as FragmentActivity).supportFragmentManager.beginTransaction().replace(R.id.content, Shop()).commit()

                    // Закрытие Панели
                    dismiss()
                }

                R.id.favoritesMenu -> {

                }

                R.id.accountMenu -> {

                }

                R.id.contactMenu -> {

                }

                R.id.videoMenu -> {

                }


                R.id.locationMenu -> {
                }

                R.id.settingsMenu -> {
                }

                R.id.helpMenu -> {

                }

                R.id.developerMenu -> {

                }

            }
            true
        }

        return binding?.root
    }

}