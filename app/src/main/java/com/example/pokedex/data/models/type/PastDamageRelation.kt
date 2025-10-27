package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PastDamageRelation(
    @SerialName("damage_relations")
    val damageRelations: DamageRelationsX?,
    @SerialName("generation")
    val generation: GenerationX?
)