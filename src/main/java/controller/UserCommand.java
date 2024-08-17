package controller;

public enum UserCommand {

        SIGNUP("1"),
        SIGNIN("2");

        private final String value;

        UserCommand(String value) {
                this.value = value;

        }
        /**
         * Получает команду по ее значению.
         * @param value значение команды
         * @return команда, соответствующая заданному значению
         * @throws RuntimeException если команда не найдена
         */
        public static UserCommand getCommandByValue(String value) {
                // Перебираем все команды и ищем ту, которая соответствует заданному значению.
                for (UserCommand command : values()) {
                        if (command.value.equals(value)) {
                                return command;
                        }
                } //если команда не найдена бросаем исключение
                throw new RuntimeException("Некорректный выбор");

        }
}


