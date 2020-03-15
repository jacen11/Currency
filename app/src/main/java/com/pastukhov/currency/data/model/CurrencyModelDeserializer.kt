package com.pastukhov.currency.data.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class CurrencyModelDeserializer : JsonDeserializer<CurrencyModel> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): CurrencyModel =
        CurrencyModel(json?.asJsonObject?.entrySet()?.first()?.value?.asString ?: "0")
}
