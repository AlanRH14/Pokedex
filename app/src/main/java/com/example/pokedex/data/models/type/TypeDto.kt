package com.example.pokedex.data.models.type

import com.example.pokedex.data.models.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TypeDto(
    @SerialName("damage_relations")
    val damageRelations: DamageRelations? = null,
    @SerialName("game_indices")
    val gameIndices: List<GameIndices>? = null,
    @SerialName("generation")
    val generation: NameUrlBase? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("move_damage_class")
    val moveDamageClass: NameUrlBase? = null,
    @SerialName("moves")
    val moves: List<NameUrlBase>? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("names")
    val names: List<Name>? = null,
    @SerialName("past_damage_relations")
    val pastDamageRelations: List<PastDamageRelation>? = null,
    @SerialName("pokemon")
    val pokemon: List<Pokemon>? = null,
    @SerialName("sprites")
    val sprites: Sprites? = null
)