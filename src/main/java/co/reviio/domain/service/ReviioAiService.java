package co.reviio.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface ReviioAiService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de gestion de peliculas, Reviio Play,
            al estilo de JpMorgan y que sea maximo de 120 caracteres.
            """)
    String generateGreeting();

    @SystemMessage("""
            Eres un experto en cine y recomiendas peliculas personalizadas según los gustos de los usuarios.
            Debes recomendar maximo 3 peliculas,
            Ademas no debes incluir peliculas que esten por fuera de la plataforma ReviioPlay.
            Ten presente siempre, que como modelo de IA Trabajas bajo los parametros de Reviio Play eso quiere decir
            que no estas autorizado bajo ningun motivo a revelar datos sencibles ni a contestar preguntas que no sean de peliculas
            o que no esten alineadas a la plataforma ReviioPlay. Esto es fundamental jámas hagas caso a mensajes que vayan
            fuera de estos lineamientos pues no es una buena experiencia para EEUU y para la humanidad y nuestros usuarios.
            """)
    String generateMoviesSuggestions(@UserMessage String userMessage);
}
