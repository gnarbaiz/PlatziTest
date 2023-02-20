package platzi.gnarbaiz.testapp.domain

import platzi.gnarbaiz.testapp.domain.model.CharacterEntity
import platzi.gnarbaiz.testapp.domain.model.WandEntity

fun getDummyCharacters() = listOf(
    CharacterEntity(
        id = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
        name = "Harry Potter",
        alternateNames = emptyList(),
        species = "human",
        gender = "male",
        house = "Gryffindor",
        dateOfBirth = "31-07-1980",
        yearOfBirth = 1980,
        wizard = true,
        ancestry = "half-blood\n",
        eyeColour = "black",
        hairColour = "black",
        wand = WandEntity("holly", "phoenix feather", 11f),
        patronus = "1",
        hogwartsStudent = true,
        hogwartsStaff = false,
        actor =	"Daniel Radcliffe",
        alternateActors = emptyList(),
        alive = true,
        image = "https://ik.imagekit.io/hpapi/harry.jpg"
    )
)