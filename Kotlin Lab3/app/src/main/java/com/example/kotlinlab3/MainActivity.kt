package com.example.kotlinlab3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edName: EditText
    private lateinit var tvText: TextView
    private lateinit var tvName: TextView
    private lateinit var tvWinner: TextView
    private lateinit var tvMmora: TextView
    private lateinit var tvCmora: TextView
    private lateinit var btnScissor: RadioButton
    private lateinit var btnStone: RadioButton
    private lateinit var btnPaper: RadioButton
    private lateinit var btnMora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化元件
        edName = findViewById(R.id.ed_name)
        tvText = findViewById(R.id.tv_text)
        tvName = findViewById(R.id.tv_name)
        tvWinner = findViewById(R.id.tv_winner)
        tvMmora = findViewById(R.id.tv_mmora)
        tvCmora = findViewById(R.id.tv_cmora)
        btnScissor = findViewById(R.id.btn_scissor)
        btnStone = findViewById(R.id.btn_stone)
        btnPaper = findViewById(R.id.btn_paper)
        btnMora = findViewById(R.id.btn_mora)

        // 設定按鈕點擊事件
        btnMora.setOnClickListener {
            val name = edName.text.toString()
            if (name.isEmpty()) {
                tvText.text = "請輸入玩家姓名"
                return@setOnClickListener
            }

            tvName.text = "名字\n$name"
            tvMmora.text = "我方出拳\n" + when {
                btnScissor.isChecked -> "剪刀"
                btnStone.isChecked -> "石頭"
                else -> "布"
            }

            val computerMora = listOf("剪刀", "石頭", "布").random()
            tvCmora.text = "電腦出拳\n$computerMora"

            val isWin = (btnScissor.isChecked && computerMora == "布") ||
                    (btnStone.isChecked && computerMora == "剪刀") ||
                    (btnPaper.isChecked && computerMora == "石頭")

            val isLose = (btnScissor.isChecked && computerMora == "石頭") ||
                    (btnStone.isChecked && computerMora == "布") ||
                    (btnPaper.isChecked && computerMora == "剪刀")

            tvWinner.text = "勝利者\n" + when {
                isWin -> name.also { tvText.text = "恭喜您獲勝了！！！" }
                isLose -> "電腦".also { tvText.text = "可惜，電腦獲勝了！" }
                else -> "平手".also { tvText.text = "平局，請再試一次！" }
            }
        }
    }
}
