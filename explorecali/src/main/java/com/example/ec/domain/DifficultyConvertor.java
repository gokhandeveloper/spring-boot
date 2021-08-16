package com.example.ec.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DifficultyConvertor implements AttributeConverter<Difficulty, String> {
    @Override
    public String convertToDatabaseColumn(Difficulty difficulty) {
        return difficulty.getDifficulty();
    }

    @Override
    public Difficulty convertToEntityAttribute(String s) {
        return Difficulty.findByDifficulty(s);
    }
}
