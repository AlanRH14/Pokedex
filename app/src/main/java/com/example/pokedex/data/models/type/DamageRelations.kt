package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DamageRelations(
    @SerialName("double_damage_from")
    val damage: List<Damage?>?,
    @SerialName("double_damage_to")
    val doubleDamageTo: List<Damage?>?,
    @SerialName("half_damage_from")
    val halfDamageFrom: List<Damage?>?,
    @SerialName("half_damage_to")
    val halfDamageTo: List<Damage?>?,
    @SerialName("no_damage_from")
    val noDamageFrom: List<Damage?>?,
    @SerialName("no_damage_to")
    val noDamageTo: List<NoDamageTo?>?
)