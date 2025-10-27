package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DamageRelationsX(
    @SerialName("double_damage_from")
    val damage: List<Damage>?,
    @SerialName("double_damage_to")
    val doubleDamageTo: List<DoubleDamageTo>?,
    @SerialName("half_damage_from")
    val halfDamageFrom: List<HalfDamageFrom>?,
    @SerialName("half_damage_to")
    val halfDamageTo: List<HalfDamageTo>?,
    @SerialName("no_damage_from")
    val noDamageFrom: List<NoDamageFrom>?,
    @SerialName("no_damage_to")
    val noDamageTo: List<NoDamageTo>?
)