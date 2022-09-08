package com.mediconear.start

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.mediconear.R
import com.mediconear.navigation.Router
import com.mediconear.navigation.RoutingActionConsumer
import com.mediconear.navigation.RoutingActionsSource
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class StartActivity : AppCompatActivity(R.layout.activity_start), RoutingActionConsumer {

    private val routingActionsSource: RoutingActionsSource by inject()
    private val router: Router by inject(parameters = { parametersOf(this) })

    companion object {
        fun createIntent(context: Context, isAfterLogout: Boolean): Intent =
            Intent(context, StartActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (window.decorView as ViewGroup).children.first().setBackgroundResource(R.color.mediconear_white)

        if (savedInstanceState == null) {
            router.showLandingScreen()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        routingActionsSource.setActiveRoutingActionConsumer(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        routingActionsSource.unsetRoutingActionConsumer(this)
        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        if (shouldUnsetRoutingActionConsumer()) {
            routingActionsSource.unsetRoutingActionConsumer(this)
        }
        super.onPause()
    }

    private fun shouldUnsetRoutingActionConsumer() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) isInMultiWindowMode.not() else true

    override fun onRoutingAction(routingAction: (Router) -> Unit) = routingAction(router)

    override fun onBackPressed() = router.goBack()
}

