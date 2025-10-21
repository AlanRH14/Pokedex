package com.example.pokedex.navigation

import kotlinx.serialization.Serializable

interface TabsNavRoute {
    @Serializable
    data object About : TabsNavRoute
    @Serializable
    data object Stats : TabsNavRoute
    @Serializable
    data object Defence: TabsNavRoute
    @Serializable
    data object Evolution: TabsNavRoute
}