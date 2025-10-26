package com.example.shuttleapp.presentation.state

import com.example.shuttleapp.data.local.ShuttlePassWithPassengerEntity

data class FilterState(
    var currentFilter: FilterType = FilterType.All,
    val list: List<ShuttlePassWithPassengerEntity> = emptyList()
)

enum class FilterType {
    All, Late, NotSynced
}