package ru.halievjanat.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.halievjanat.builder.Hero;

@AllArgsConstructor
@Data
public class GameEvent {
    private EventType eventType;
    private Hero source;
}
