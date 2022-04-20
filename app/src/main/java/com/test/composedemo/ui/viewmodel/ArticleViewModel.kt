package com.test.composedemo.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.test.composedemo.model.entity.ArticleEntity

class ArticleViewModel : ViewModel() {


    var list = listOf(
        ArticleEntity(
            title = "15省份38000多名医务人员驰援上海",
            source = "环球网",
            timestamp = "2022-04-05"
        ),
        ArticleEntity(
            title = "上海一女子网上抢千元菜被大妈偷走",
            source = "江南都市报",
            timestamp = "2022-04-05"
        ),
        ArticleEntity(
            title = "官方回应社区与援沪医疗队起冲突",
            source = "焦点资讯",
            timestamp = "2022-04-05"
        ),
        ArticleEntity(
            title = "上海社区干部与外省援沪医疗队起冲突？官方回应：医护来自本地，政府已道歉",
            source = "焦点资讯",
            timestamp = "2022-04-05"
        ),
        ArticleEntity(
            title = "官方回应社区与援沪医疗队起冲突",
            source = "焦点资讯",
            timestamp = "2022-04-05"
        ),
        ArticleEntity(
            title = "官方回应社区与援沪医疗队起冲突",
            source = "焦点资讯",
            timestamp = "2022-04-05"
        ),
        ArticleEntity(
            title = "官方回应社区与援沪医疗队起冲突",
            source = "焦点资讯",
            timestamp = "2022-04-05"
        ),
        ArticleEntity(
            title = "官方回应社区与援沪医疗队起冲突",
            source = "焦点资讯",
            timestamp = "2022-04-05"
        ),
        ArticleEntity(
            title = "官方回应社区与援沪医疗队起冲突",
            source = "焦点资讯",
            timestamp = "2022-04-05"
        ), ArticleEntity(
            title = "官方回应社区与援沪医疗队起冲突End",
            source = "焦点资讯",
            timestamp = "2022-04-05"
        )


    )
        private set
}