package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DamageRelations(
    @SerialName("double_damage_from")
    val damage: List<Damage?>? = null,
    @SerialName("double_damage_to")
    val doubleDamageTo: List<Damage?>? = null,
    @SerialName("half_damage_from")
    val halfDamageFrom: List<Damage?>? = null,
    @SerialName("half_damage_to")
    val halfDamageTo: List<Damage?>? = null,
    @SerialName("no_damage_from")
    val noDamageFrom: List<Damage?>? = null,
    @SerialName("no_damage_to")
    val noDamageTo: List<Damage?>? = null
)