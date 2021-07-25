package com.example.diceroller

import android.content.Intent
import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.*
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var number = 0

    private var numbers: MutableList<Int> = mutableListOf()

    private lateinit var sp: SoundPool
    private var sound1 = 0
    private var sound2 = 0
    private var stream1 = 0
    private var stream2 = 0

    private val timer = object: CountDownTimer(2000, 100){
        override fun onTick(millisUntilFinished: Long) {
            binding.btnRoll.isEnabled = false
            roll()
        }

        override fun onFinish() {
            binding.btnRoll.isEnabled = true

            numbers.add(number)
            while(numbers.size > 5) numbers.removeFirst()
            binding.txtRolls.text = "Last 5 Rolls = ${numbers.joinToString(" - ")}"

            sp.stop(stream2)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadSound()

        binding.btnRoll.setOnClickListener{
            timer.start()
            stream2 = sp.play(sound2, 1F, 1F, 1, -1, 1F)
        }

//        _ means discard
        binding.tbnMusic.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                binding.tbnMusic.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_on, 0, 0, 0)
                sp.setVolume(stream1, 0.25F, 0.25F)
            }
            else{
                binding.tbnMusic.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_off, 0, 0, 0)
                sp.setVolume(stream1, 0F, 0F)
            }
        }

        binding.btnAbout.setOnClickListener{
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        sp.autoResume()
    }

    override fun onPause() {
        super.onPause()
        sp.autoPause()

    }

    private fun loadSound(){
        val attr = AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_MEDIA).
            setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build()

        sp = SoundPool.Builder().setMaxStreams(2).setAudioAttributes(attr).build()

        sound1 = sp.load(this, R.raw.bgm, 1)
        sound2 = sp.load(this, R.raw.dice, 1)

        sp.setOnLoadCompleteListener{ _, sampleId, _ ->
            when (sampleId){
                sound1 -> stream1 = sp.play(sound1, 0.25F, 0.25F, 1, -1, 1F)
            }
        }
    }

    private fun roll(){
        val n = (1..6).random()
        val r = when (n) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.txtNumber.text = "$n"

        binding.img.setImageResource(r)

        number = n
    }

}