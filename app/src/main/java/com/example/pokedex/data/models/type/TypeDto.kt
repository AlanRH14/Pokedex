package com.example.pokedex.data.models.type

import com.example.pokedex.data.models.type.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TypeDto(
    @SerialName("damage_relations")
    val damageRelations: DamageRelations?,
    @SerialName("game_indices")
    val gameIndices: List<GameIndices>?,
    @SerialName("generation")
    val generation: NameUrlBase?,
    @SerialName("id")
    val id: Int?,
    @SerialName("move_damage_class")
    val moveDamageClass: NameUrlBase?,
    @SerialName("moves")
    val moves: List<NameUrlBase>?,
    @SerialName("name")
    val name: String?,
    @SerialName("names")
    val names: List<Name>?,
    @SerialName("past_damage_relations")
    val pastDamageRelations: List<PastDamageRelation>?,
    @SerialName("pokemon")
    val pokemon: List<Pokemon>?,
    @SerialName("sprites")
    val sprites: Sprites?
)