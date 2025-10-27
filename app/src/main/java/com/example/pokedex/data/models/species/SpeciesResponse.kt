package com.example.pokedex.data.models.species

import com.example.pokedex.data.models.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpeciesResponse(
    @SerialName("base_happiness")
    val baseHappiness: Int? = null,
    @SerialName("capture_rate")
    val captureRate: Int? = null,
    @SerialName("color")
    val color: NameUrlBase? = null,
    @SerialName("egg_groups")
    val eggGroups: List<NameUrlBase>? = null,
    @SerialName("evolution_chain")
    val evolutionChain: EvolutionChain? = null,
    @SerialName("evolves_from_species")
    val evolvesFromSpecies: NameUrlBase? = null,
    @SerialName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>? = null,
    @SerialName("form_descriptions")
    val formDescriptions: List<FormDescription?>? = null,
    @SerialName("forms_switchable")
    val formsSwitchable: Boolean? = null,
    @SerialName("gender_rate")
    val genderRate: Int? = null,
    @SerialName("genera")
    val genera: List<Genera>? = null,
    @SerialName("generation")
    val generation: NameUrlBase? = null,
    @SerialName("growth_rate")
    val growthRate: NameUrlBase? = null,
    @SerialName("habitat")
    val habitat: NameUrlBase? = null,
    @SerialName("has_gender_differences")
    val hasGenderDifferences: Boolean? = null,
    @SerialName("hatch_counter")
    val hatchCounter: Int? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("is_baby")
    val isBaby: Boolean? = null,
    @SerialName("is_legendary")
    val isLegendary: Boolean? = null,
    @SerialName("is_mythical")
    val isMythical: Boolean? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("names")
    val names: List<Name>? = null,
    @SerialName("order")
    val order: Int? = null,
    @SerialName("pal_park_encounters")
    val palParkEncounters: List<PalParkEncounter>? = null,
    @SerialName("pokedex_numbers")
    val pokedexNumbers: List<PokedexNumber>? = null,
    @SerialName("shape")
    val shape: NameUrlBase? = null,
    @SerialName("varieties")
    val varieties: List<Variety>? = null
)