package com.example.pokedex.data.models.specie


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpeciesResponse(
    @SerialName("base_happiness")
    val baseHappiness: Int?,
    @SerialName("capture_rate")
    val captureRate: Int?,
    @SerialName("color")
    val color: Color?,
    @SerialName("egg_groups")
    val eggGroups: List<EggGroup>?,
    @SerialName("evolution_chain")
    val evolutionChain: EvolutionChain?,
    @SerialName("evolves_from_species")
    val evolvesFromSpecies: EvolvesFromSpecies?,
    @SerialName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>?,
    @SerialName("form_descriptions")
    val formDescriptions: List<FormDescription?>?,
    @SerialName("forms_switchable")
    val formsSwitchable: Boolean?,
    @SerialName("gender_rate")
    val genderRate: Int?,
    @SerialName("genera")
    val genera: List<Genera>?,
    @SerialName("generation")
    val generation: Generation?,
    @SerialName("growth_rate")
    val growthRate: GrowthRate?,
    @SerialName("habitat")
    val habitat: Habitat?,
    @SerialName("has_gender_differences")
    val hasGenderDifferences: Boolean?,
    @SerialName("hatch_counter")
    val hatchCounter: Int?,
    @SerialName("id")
    val id: Int?,
    @SerialName("is_baby")
    val isBaby: Boolean?,
    @SerialName("is_legendary")
    val isLegendary: Boolean?,
    @SerialName("is_mythical")
    val isMythical: Boolean?,
    @SerialName("name")
    val name: String?,
    @SerialName("names")
    val names: List<Name>?,
    @SerialName("order")
    val order: Int?,
    @SerialName("pal_park_encounters")
    val palParkEncounters: List<PalParkEncounter>?,
    @SerialName("pokedex_numbers")
    val pokedexNumbers: List<PokedexNumber>?,
    @SerialName("shape")
    val shape: Shape?,
    @SerialName("varieties")
    val varieties: List<Variety>?
)