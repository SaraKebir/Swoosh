package com.sara.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sara.swoosh.Model.Player
import com.sara.swoosh.R
import com.sara.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {


    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER,player)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState!=null){
            player=savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }
    fun onMensClicked(view: View){
        coedLeagueBtn.isChecked=false
        womensLeagueBtn.isChecked=false
       player.league="men\'s"
    }
    fun onWomensClicked (view: View){
        coedLeagueBtn.isChecked=false
        mensLeagueBtn.isChecked=false
        player.league="women\'s"
    }

    fun onCoedClicked(view: View){
        womensLeagueBtn.isChecked=false
        mensLeagueBtn.isChecked=false
        player.league="coed"
    }

    fun leagueNextClicked(view:View){
        if (player.league!=""){
            val skillActivity =Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER,player)
            startActivity(skillActivity)
        }else{
            Toast.makeText(this,"Please select a League",Toast.LENGTH_SHORT).show()

        }

    }
}
