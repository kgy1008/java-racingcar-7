package racingcar.model.car

import racingcar.common.ErrorMessage
import java.util.*
import java.util.regex.Pattern

class Name internal constructor(name: String) {
    val name: String

    init {
        validate(name)
        this.name = name
    }

    private fun validate(name: String) {
        validateBlankName(name)
        validateNameLength(name)
        validateNameCharacters(name)
    }

    private fun validateBlankName(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.message)
        }
    }

    private fun validateNameLength(name: String) {
        if (name.length > MAX_NAME_LENGTH || name.isBlank()) {
            throw IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.message)
        }
    }

    private fun validateNameCharacters(name: String) {
        if (!VALID_NAME_PATTERN.matcher(name).matches()) {
            throw IllegalArgumentException(ErrorMessage.NAME_INVALID_CHARACTER.message)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val carName = other as Name
        return name == carName.name
    }

    override fun hashCode(): Int {
        return Objects.hashCode(name)
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private val VALID_NAME_PATTERN: Pattern = Pattern.compile("^[a-zA-Z0-9]+$")
    }
}
