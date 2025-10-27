package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PastDamageRelation(
    @SerialName("damage_relations")
    val damageRelations: DamageRelations?,
    @SerialName("generation")
    val generation: Generation?
)