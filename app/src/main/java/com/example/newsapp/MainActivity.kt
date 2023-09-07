package com.example.newsapp

import TitleFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TitleFragment.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var titleFragment: TitleFragment
    private lateinit var articleFragment: DetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = arrayListOf<NewsItem>()
        dataList.add(
            NewsItem(
                R.drawable.newspage1,
                "대통령 차량 이동 통제 도중 경찰차 · 택시 충돌…4명 부상",
                "대통령 차량 이동을 위해 도로 통제가 이뤄지던 중 경찰차와 택시가 충돌하는 사고가 발생했습니다.\n" +
                        "\n" +
                        "오늘(1일) 오후 11시 5분쯤 서울 서초구 반포대로 예술의전당 방면으로 주행하던 택시가 반대편에서 좌회전하던 경찰 승합차와 부딪쳤습니다.\n" +
                        "\n" +
                        "이 사고로 택시에 타고 있던 20대 여성과 택시기사가 경상을 입어 병원으로 이송됐고, 승합차에 타 있던 경찰관 2명도 경상을 입었습니다.\n" +
                        "\n" +
                        "사고 당시 택시는 경찰관의 수신호를 보지 못하고 녹색 신호에 맞춰 4차로로 직진하던 중 충돌한 것으로 파악됐습니다.\n" +
                        "\n" +
                        "서울경찰청 교통순찰대는 대통령 차량 이동을 위해 서초경찰서 앞 일대를 교통 통제하던 중이었는데, 사고 직후 대통령 차량이 현장을 지나간 것으로 알려졌습니다.\n" +
                        "\n" +
                        "경찰은 수신호를 왜 못 봤는지 경찰과 택시기사를 상대로 조사할 예정이라고 밝혔습니다."
            )
        )
        dataList.add(
            NewsItem(
                R.drawable.newspage2,
                "[속보] 부산 목욕탕 폭발 부상자 21명으로 늘어…중상 2명 · 경상 19명",
                "부산 목욕탕 폭발 부상자 21명으로 늘어…중상 2명·경상 19명"
            )
        )
        dataList.add(
            NewsItem(
                R.drawable.newspage3,
                "전 수사단장, 군검찰과 법원 출입문 앞 3시간 대치하다 강제구인",
                "해병대 채 모 상병 순직 사건을 수사하다 항명 등의 혐의로 입건된 박정훈 전 해병대 수사단장이 오늘(1일) 구속 전 피의자 심문을 위해 군사법원 입구까지 갔다가 강제구인됐습니다.\n" +
                        "\n" +
                        "박 전 단장과 법률대리인들은 오늘 오전 10시로 예정됐던 구속 전 심문을 위해 오전 9시 반쯤 서울 용산 중앙지역군사법원에 도착했습니다.\n" +
                        "\n" +
                        "그러나 군사법원이 법원 건물로 바로 들어갈 수 있는 출입문을 열지 않자 박 전 단장과 변호인단은 출입문 개방을 요구하며 출석을 거부했습니다.\n" +
                        "\n" +
                        "변호인단은 군사법원이 일상적인 재판 때는 개방해두던 출입문을 폐쇄하고 국방부 위병소를 통해 출입 조치를 한 후, 국방부 검찰단을 통해 법원에 출석할 것을 요구했다고 설명했습니다.\n" +
                        "\n" +
                        "통상 심문의 경우 검사가 구인영장을 집행해 피고인을 구인한 후 검사와 피고인이 함께 법원에 출석하지만, 이때까지 군검찰은 구인영장을 집행하지 않았습니다.\n" +
                        "\n" +
                        "이에 따라 박 전 단장과 변호인단은 임의의 방법으로 법원에 출석할 수 있는 것으로 받아들였으나, 군사법원이 출입문을 개방하지 않아 출석 방법을 제한했다고 주장했습니다.\n" +
                        "\n" +
                        "출입문 앞 대치가 1시간 넘게 이어지자 야당 국회의원 8명이 오전 11시 20분쯤 중앙지역군사법원이 있는 국방부 후문으로 찾아와 국방부 검찰단에 항의했습니다.\n" +
                        "\n" +
                        "더불어민주당 소병철·박범계·박주민·박용진 ·김승원·이수진·최강욱·윤주병 의원은 군검찰에 박 전 단장과 변호인단의 주장을 수용해달라고 요구했으나, 군검찰은 이를 거절했습니다.\n" +
                        "\n" +
                        "이어 정오 무렵 국방부 후문 일대에 경찰 기동대가 배치됐고, 군검찰은 구인영장을 집행해 민원실에 있던 박 전 단장을 강제구인했습니다."
            )
        )

        titleFragment = TitleFragment(dataList)
        articleFragment = DetailFragment()

        binding.rvTitle.layoutManager = LinearLayoutManager(this)
        binding.rvTitle.adapter = titleFragment
    }



    override fun onItemClick(item: NewsItem) {
        val bundle = Bundle()
        bundle.putString("TITLE", item.title)
        bundle.putString("ARTICLE", item.article)
        bundle.putInt("IMG", item.imagenews)

        articleFragment.arguments = bundle

        replaceFragment(articleFragment)
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.titleFragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

        titleFragment.setOnItemClickListener(object : TitleFragment.OnItemClickListener {
            override fun onItemClick(item: NewsItem) {

                val bundle = Bundle()
                bundle.putString("TITLE", item.title)
                bundle.putString("ARTICLE", item.article)
                bundle.putInt("IMG", item.imagenews)

                articleFragment.arguments = bundle

                replaceFragment(articleFragment)
            }
        })
    }
}