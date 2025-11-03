package com.example.pokedex.data.models.type

import com.example.pokedex.data.models.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DamageRelations(
    @SerialName("double_damage_from")
    val doubleDamageFrom: List<NameUrlBase>? = null,
    @SerialName("double_damage_to")
    val doubleDamageTo: List<NameUrlBase>? = null,
    @SerialName("half_damage_from")
    val halfDamageFrom: List<NameUrlBase>? = null,
    @SerialName("half_damage_to")
    val halfDamageTo: List<NameUrlBase>? = null,
    @SerialName("no_damage_from")
    val noDamageFrom: List<NameUrlBase>? = null,
    @SerialName("no_damage_to")
    val noDamageTo: List<NameUrlBase>? = null,
)