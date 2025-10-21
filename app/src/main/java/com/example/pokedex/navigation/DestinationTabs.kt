package com.example.pokedex.navigation

enum class DestinationTabs(
    val title: String,
    val route: TabsNavRoute) {
    INFORMATION(title = "About", route = TabsNavRoute.About),
    STATS(title = "Stats", route = TabsNavRoute.Stats),
    DEFENCE(title = "Defence", route = TabsNavRoute.Defence),
    EVOLUTION(title = "Evolution", route = TabsNavRoute.Evolution)
}