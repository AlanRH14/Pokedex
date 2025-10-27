package com.example.pokedex.data.models.type

import com.example.pokedex.data.models.type.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DamageRelations(
    @SerialName("double_damage_from")
    val damage: List<NameUrlBase?>?,
    @SerialName("double_damage_to")
    val doubleDamageTo: List<NameUrlBase?>?,
    @SerialName("half_damage_from")
    val halfDamageFrom: List<NameUrlBase?>?,
    @SerialName("half_damage_to")
    val halfDamageTo: List<NameUrlBase?>?,
    @SerialName("no_damage_from")
    val noDamageFrom: List<NameUrlBase?>?,
    @SerialName("no_damage_to")
    val noDamageTo: List<NameUrlBase?>?
)