package com.example.pokedex.data.models.type

import com.example.pokedex.data.models.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PastDamageRelation(
    @SerialName("damage_relations")
    val damageRelations: DamageRelations? = null,
    @SerialName("generation")
    val generation: NameUrlBase? = null
)