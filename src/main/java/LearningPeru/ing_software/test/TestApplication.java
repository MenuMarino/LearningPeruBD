package LearningPeru.ing_software.test;

import LearningPeru.ing_software.test.Entity.Course;
import LearningPeru.ing_software.test.repositories.CourseRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TestApplication {

    @Autowired
    private CourseRepository  courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            courseRepository.save(new Course("Quimica",3,"Introduccion_a_la_química"));
            courseRepository.save(new Course("Quimica",3,"Atomos,_moleculas_e_iones"));
            courseRepository.save(new Course("Quimica",3,"La_tabla_periodica"));
            courseRepository.save(new Course("Quimica",3,"Nomenclatura_de_los_compuestos"));
            courseRepository.save(new Course("Quimica",3,"Relaciones_de_masa_en_las_reacciones_quimicas "));
            courseRepository.save(new Course("Quimica",3,"Estequiometria_de_reaccion"));
            courseRepository.save(new Course("Quimica",3,"Relaciones_de_masa_en_solución"));

            courseRepository.save(new Course("Quimica",4,"Formula_empírica_y_molecular"));
            courseRepository.save(new Course("Quimica",4,"Presion"));
            courseRepository.save(new Course("Quimica",4,"Estado_gaseoso"));
            courseRepository.save(new Course("Quimica",4,"Mezcla_de_gases"));
            courseRepository.save(new Course("Quimica",4,"Reacciones_químicas"));
            courseRepository.save(new Course("Quimica",4,"Balance_de_ecuaciones"));
            courseRepository.save(new Course("Quimica",4,"Complemento_de_Redox"));
            courseRepository.save(new Course("Quimica",4,"Balance_de_ecuaciones,_metodo_Ion_electron-_medio_acido"));
            courseRepository.save(new Course("Quimica",4,"Estequiometria_I"));
            courseRepository.save(new Course("Quimica",4,"Estequiometria_II"));
            courseRepository.save(new Course("Quimica",4,"Masa equivalente_y_equivalente_gramo"));
            courseRepository.save(new Course("Quimica",4,"Solubilidad"));
            courseRepository.save(new Course("Quimica",4,"Molaridad_y_Normalidad "));
            courseRepository.save(new Course("Quimica",4,"Dilucion_y_mezcla_de_soluciones"));
            courseRepository.save(new Course("Quimica",4,"Neutralizacion_de_una_solucion"));
            courseRepository.save(new Course("Quimica",4,"Teorias_de_acidos_y_bases"));

             courseRepository.save(new Course("Quimica",5,"Introducción_a_la_química orgánica"));
             courseRepository.save(new Course("Quimica",5,"Hidrocarburos,_Alcanos"));
             courseRepository.save(new Course("Quimica",5,"Alquenos_y_alquinos"));
             courseRepository.save(new Course("Quimica",5,"Compuestos_ciclicos_y_aromaticos"));
             courseRepository.save(new Course("Quimica",5,"Densidad"));
             courseRepository.save(new Course("Quimica",5,"Estructura_atomica "));
             courseRepository.save(new Course("Quimica",5,"Quimica_nuclear"));
             courseRepository.save(new Course("Quimica",5,"Números_cuanticos"));
             courseRepository.save(new Course("Quimica",5,"Configuracion_electronica"));
             courseRepository.save(new Course("Quimica",5,"Tabla periodica"));
             courseRepository.save(new Course("Quimica",5,"Enlace_quimico_I"));
             courseRepository.save(new Course("Quimica",5,"Enlace_quimico_II"));
             courseRepository.save(new Course("Quimica",5,"Unidades_quimicas_de_masa"));
             courseRepository.save(new Course("Quimica",5,"Calculos_masicos"));
             courseRepository.save(new Course("Quimica",5,"Reacciones_quimicas"));
             courseRepository.save(new Course("Quimica",5,"Balance_de_ecuaciones_Metodo_redox"));
             courseRepository.save(new Course("Quimica",5,"Estequiometria_I"));
             courseRepository.save(new Course("Quimica",5,"Estequiometria_II"));
             courseRepository.save(new Course("Quimica",5,"Soluciones_I"));
             courseRepository.save(new Course("Quimica",5,"Soluciones_II"));
             courseRepository.save(new Course("Quimica",5,"Neutralizacion"));
             courseRepository.save(new Course("Quimica",5,"Cinetica_quimica_y_equilibrio_quimico"));
             courseRepository.save(new Course("Quimica",5,"Teorias_de_acidos_y_bases"));
             courseRepository.save(new Course("Quimica",5,"Electrolisis"));
             courseRepository.save(new Course("Quimica",5,"Funciones_quimicas_organicas"));

            courseRepository.save(new Course("Comunicacion",1,"Acentuacion"));
            courseRepository.save(new Course("Comunicacion",1,"Signos_de_puntuacion"));
            courseRepository.save(new Course("Comunicacion",1,"Uso_de_mayusculas"));
            courseRepository.save(new Course("Comunicacion",1,"Queismo_y_dequeismo"));
            courseRepository.save(new Course("Comunicacion",1,"Homonimia"));
            courseRepository.save(new Course("Comunicacion",1,"Textos_literarios"));
            courseRepository.save(new Course("Comunicacion",1,"Ensayos"));
            courseRepository.save(new Course("Comunicacion",1,"Generos_literarios"));
            courseRepository.save(new Course("Comunicacion",1,"Sustantivo_y_adjetivo"));
            courseRepository.save(new Course("Comunicacion",1,"Pronombre_y_determinante"));
            courseRepository.save(new Course("Comunicacion",1,"Verbo"));
            courseRepository.save(new Course("Comunicacion",1,"Adverbio"));
            courseRepository.save(new Course("Comunicacion",1,"Estructuras_de_oraciones"));
            courseRepository.save(new Course("Comunicacion",1,"Microconferencias"));
            courseRepository.save(new Course("Comunicacion",1,"Debates"));

            courseRepository.save(new Course("Comunicacion",2,"Acentuacion"));
            courseRepository.save(new Course("Comunicacion",2,"Signos_de_puntuacion"));
            courseRepository.save(new Course("Comunicacion",2,"Uso_de_mayusculas"));
            courseRepository.save(new Course("Comunicacion",2,"Palabras_de_escritura_problematica"));
            courseRepository.save(new Course("Comunicacion",2,"Homonimia"));
            courseRepository.save(new Course("Comunicacion",2,"Estrategias_de_estructuracion_de_ideas"));
            courseRepository.save(new Course("Comunicacion",2,"Conectores"));
            courseRepository.save(new Course("Comunicacion",2,"Articulos"));
            courseRepository.save(new Course("Comunicacion",2,"Ensayos"));
            courseRepository.save(new Course("Comunicacion",2,"Literatura_peruana"));
            courseRepository.save(new Course("Comunicacion",2,"Sustantivo_y_adjetivo"));
            courseRepository.save(new Course("Comunicacion",2,"Pronombre_y_determinante"));
            courseRepository.save(new Course("Comunicacion",2,"Verbo"));
            courseRepository.save(new Course("Comunicacion",2,"Adverbio"));
            courseRepository.save(new Course("Comunicacion",2,"Estructuras_de_oraciones"));
            courseRepository.save(new Course("Comunicacion",2,"Exposicion"));
            courseRepository.save(new Course("Comunicacion",2,"Compresion_de_textos"));

            courseRepository.save(new Course("Comunicacion",3,"Acentuacion"));
            courseRepository.save(new Course("Comunicacion",3,"Signos_de_puntuacion"));
            courseRepository.save(new Course("Comunicacion",3,"Uso_de_mayusculas"));
            courseRepository.save(new Course("Comunicacion",3,"Palabras_de_escritura_problematica"));
            courseRepository.save(new Course("Comunicacion",3,"Homonimia"));
            courseRepository.save(new Course("Comunicacion",3,"Lenguaje_academico"));
            courseRepository.save(new Course("Comunicacion",3,"Metodologia_de_la_investigacion"));
            courseRepository.save(new Course("Comunicacion",3,"Literatura_mundial"));
            courseRepository.save(new Course("Comunicacion",3,"Verbos"));
            courseRepository.save(new Course("Comunicacion",3,"Comentario_oral_individual"));
            courseRepository.save(new Course("Comunicacion",3,"Comprension_de_textos"));

            courseRepository.save(new Course("Comunicacion",4,"Lengua_y_comunidades"));
            courseRepository.save(new Course("Comunicacion",4,"Lengua_y_poder"));
            courseRepository.save(new Course("Comunicacion",4,"Lengua_y_traduccion"));
            courseRepository.save(new Course("Comunicacion",4,"Lengua_e_individuo"));
            courseRepository.save(new Course("Comunicacion",4,"Lengua_y_estereotipos"));
            courseRepository.save(new Course("Comunicacion",4,"Cultura_popular"));
            courseRepository.save(new Course("Comunicacion",4,"Lengua_y_campañas"));
            courseRepository.save(new Course("Comunicacion",4,"Lenguaje_persuasivo"));

            courseRepository.save(new Course("Comunicacion",5,"Literatura:_Producciones_literarias_y_sus_contextos"));

            courseRepository.save(new Course("Historia",1,"Origenes_de_la_cultura_Inca"));
            courseRepository.save(new Course("Historia",1,"Expansion_del_estado_Inca"));
            courseRepository.save(new Course("Historia",1,"Organizacion_del_estado_Inca"));
            courseRepository.save(new Course("Historia",1,"Religion_de_los_Incas"));
            courseRepository.save(new Course("Historia",1,"Arte_ancaico"));
            courseRepository.save(new Course("Historia",1,"Geografia_fisica"));
            courseRepository.save(new Course("Historia",1,"Mapas_fisicos_de_Europa_y_Africa"));
            courseRepository.save(new Course("Historia",1,"Division_del_Imperio_Romano"));
            courseRepository.save(new Course("Historia",1,"Invasiones_barbaras"));
            courseRepository.save(new Course("Historia",1,"Reinos_Germanicos"));
            courseRepository.save(new Course("Historia",1,"Del_Reino_Franco_al_Imperio_Romano"));
            courseRepository.save(new Course("Historia",1,"Imperio_Bizantino"));
            courseRepository.save(new Course("Historia",1,"Surgimiento_del_Islam"));
            courseRepository.save(new Course("Historia",1,"Europa_Feudal"));
            courseRepository.save(new Course("Historia",1,"Burguesia"));
            courseRepository.save(new Course("Historia",1,"Cruzadas"));
            courseRepository.save(new Course("Historia",1,"Iglesia Medieval"));
            courseRepository.save(new Course("Historia",1,"Crisis_del_Siglo_XIV"));
            courseRepository.save(new Course("Historia",1,"Sociedad_mediaval"));
            courseRepository.save(new Course("Historia",1,"La_guerra_de_los_cien_años"));

            courseRepository.save(new Course("Historia",2,"Geografia_Fisica"));
            courseRepository.save(new Course("Historia",2,"Guerra_de_los_cien_años"));
            courseRepository.save(new Course("Historia",2,"Estados_italianos"));
            courseRepository.save(new Course("Historia",2,"Renacimiento"));
            courseRepository.save(new Course("Historia",2,"Calvinismo"));
            courseRepository.save(new Course("Historia",2,"Guerras_de_Religion_en_el_siglo_XVI"));
            courseRepository.save(new Course("Historia",2,"Cultura_Europea_en_el_siglo_XVII"));
            courseRepository.save(new Course("Historia",2,"La_guerra_de_los_treinta_años"));
            courseRepository.save(new Course("Historia",2,"La_era_de_las_revoluciones"));
            courseRepository.save(new Course("Historia",2,"Colonizacion_Española"));
            courseRepository.save(new Course("Historia",2,"Virreinato_del_Peru"));

            courseRepository.save(new Course("Historia",3,"Virreinato_del_Peru"));
            courseRepository.save(new Course("Historia",3,"Sistema_politico"));
            courseRepository.save(new Course("Historia",3,"Actividades_economicos_durante_la_colonial"));
            courseRepository.save(new Course("Historia",3,"Sociedad_colonial"));
            courseRepository.save(new Course("Historia",3,"Crisis_colonial_e_independencia_del_Peru"));
            courseRepository.save(new Course("Historia",3,"Revolucion_cientifica_y_aparicion_de_la_ciencia_moderna"));
            courseRepository.save(new Course("Historia",3,"La_sociedad_estamental"));
            courseRepository.save(new Course("Historia",3,"Ilustracion_y_despotismo"));
            courseRepository.save(new Course("Historia",3,"Economia_y_sociedad_en_el_siglo_XVIII"));
            courseRepository.save(new Course("Historia",3,"Revolucion_francesa"));
            courseRepository.save(new Course("Historia",3,"Revolucion_industrial"));
            courseRepository.save(new Course("Historia",3,"Sociedad_y_cultura_en_el_siglo_XIX"));
            courseRepository.save(new Course("Historia",3,"Tiempo_de_crisis_y_guerra_en_el_Peru"));

            courseRepository.save(new Course("Historia",4,"Unificacion_nacional_de_Italia_y_Alemania"));
            courseRepository.save(new Course("Historia",4,"Primera_Guerra_Mundial"));
            courseRepository.save(new Course("Historia",4,"La_nueva_Europa"));
            courseRepository.save(new Course("Historia",4,"Paz_y_reconstruccion"));
            courseRepository.save(new Course("Historia",4,"Imperios_y_nacionalismo"));
            courseRepository.save(new Course("Historia",4,"Estados_autoritarios_en_el_siglo_XX"));
            courseRepository.save(new Course("Historia",4,"Avance_hacia_la_guerra_global"));
            courseRepository.save(new Course("Historia",4,"Segunda_Guerra_Mundial"));

            courseRepository.save(new Course("Historia",5,"Segunda_Guerra_Mundial"));
            courseRepository.save(new Course("Historia",5,"Tipos_de_guerras"));
            courseRepository.save(new Course("Historia",5,"Avances_tecnologicos"));
            courseRepository.save(new Course("Historia",5,"Estrategias_belicas"));
            courseRepository.save(new Course("Historia",5,"Influencia_y_participacion_de_las_potencias_extranjeras"));
            courseRepository.save(new Course("Historia",5,"Conferencias_de_Paz"));
            courseRepository.save(new Course("Historia",5,"Consecuencias_de_las_guerras"));
            courseRepository.save(new Course("Historia",5,"Expansion_alemana_e_italiana"));
            courseRepository.save(new Course("Historia",5,"Surgimiento_de_estados_autoritarios"));
            courseRepository.save(new Course("Historia",5,"La_guerra_fria"));

            courseRepository.save(new Course("Ingles",1,"Determiner"));
            courseRepository.save(new Course("Ingles",1,"Present_simple_and_continuous"));
            courseRepository.save(new Course("Ingles",1,"Past_simple_and_used_to"));
            courseRepository.save(new Course("Ingles",1,"Modals"));
            courseRepository.save(new Course("Ingles",1,"Present_perfect_and_past_simple"));
            courseRepository.save(new Course("Ingles",1,"Future_forms"));
            courseRepository.save(new Course("Ingles",1,"Conditionals"));
            courseRepository.save(new Course("Ingles",1,"Past_perfect"));
            courseRepository.save(new Course("Ingles",1,"Modal_passive"));
            courseRepository.save(new Course("Ingles",1,"Articles"));
            courseRepository.save(new Course("Ingles",1,"Vocabulary"));

            courseRepository.save(new Course("Ingles",2,"Subject_and_object_questions"));
            courseRepository.save(new Course("Ingles",2,"Present_tense"));
            courseRepository.save(new Course("Ingles",2,"Past_tense"));
            courseRepository.save(new Course("Ingles",2,"Present_perfect_and_past_simple"));
            courseRepository.save(new Course("Ingles",2,"Future_simple"));
            courseRepository.save(new Course("Ingles",2,"Passive_voice"));
            courseRepository.save(new Course("Ingles",2,"Conditionals"));
            courseRepository.save(new Course("Ingles",2,"Vocabulary"));

            courseRepository.save(new Course("Ingles",3,"Simple,_Continuous_and_Perfect_review"));
            courseRepository.save(new Course("Ingles",3,"Present_perfect_simple_and_continuous"));
            courseRepository.save(new Course("Ingles",3,"Modals_of_necessity"));
            courseRepository.save(new Course("Ingles",3,"Phrasal_verbs"));
            courseRepository.save(new Course("Ingles",3,"Narrative_tenses"));
            courseRepository.save(new Course("Ingles",3,"Modals_in_the_past"));
            courseRepository.save(new Course("Ingles",3,"Conditionals"));
            courseRepository.save(new Course("Ingles",3,"Vocabulary"));

            courseRepository.save(new Course("Ingles",4,"Linguistic_Dominance"));
            courseRepository.save(new Course("Ingles",4,"Cultural_identity"));
            courseRepository.save(new Course("Ingles",4,"Global_identity"));
            courseRepository.save(new Course("Ingles",4,"Racism"));
            courseRepository.save(new Course("Ingles",4,"Latino_Lives_Matter"));
            courseRepository.save(new Course("Ingles",4,"Mental_health"));
            courseRepository.save(new Course("Ingles",4,"Eating_disorders"));
            courseRepository.save(new Course("Ingles",4,"Alternative_medicine"));
            courseRepository.save(new Course("Ingles",4,"Vocabulary"));

            courseRepository.save(new Course("Ingles",5,"Stereotypes"));
            courseRepository.save(new Course("Ingles",5,"Education"));
            courseRepository.save(new Course("Ingles",5,"On_the_metro"));
            courseRepository.save(new Course("Ingles",5,"Substance_abuse"));
            courseRepository.save(new Course("Ingles",5,"Not_yet,_Jayette"));
            courseRepository.save(new Course("Ingles",5,"Advertising"));
            courseRepository.save(new Course("Ingles",5,"Vocabulary"));

            courseRepository.save(new Course("Matematica",1,"Conjuntos"));
            courseRepository.save(new Course("Matematica",1,"Relaciones_binarias"));
            courseRepository.save(new Course("Matematica",1,"Polinomios"));
            courseRepository.save(new Course("Matematica",1,"Potentacion"));
            courseRepository.save(new Course("Matematica",1,"Radicacion"));
            courseRepository.save(new Course("Matematica",1,"Numeros_Enteros"));
            courseRepository.save(new Course("Matematica",1,"Teoria_de_numeros"));
            courseRepository.save(new Course("Matematica",1,"Sistemas_de_numeracion"));
            courseRepository.save(new Course("Matematica",1,"Ecuaciones_e_inecuaciones"));
            courseRepository.save(new Course("Matematica",1,"Geometria"));

            courseRepository.save(new Course("Matematica",2,"Numeros_racionales"));
            courseRepository.save(new Course("Matematica",2,"Razones_y_proporciones"));
            courseRepository.save(new Course("Matematica",2,"Numeros_reales"));
            courseRepository.save(new Course("Matematica",2,"Potenciacion"));
            courseRepository.save(new Course("Matematica",2,"Radicacion"));
            courseRepository.save(new Course("Matematica",2,"Polinomios"));
            courseRepository.save(new Course("Matematica",2,"Division_de_polinomios"));
            courseRepository.save(new Course("Matematica",2,"Factorizacion"));
            courseRepository.save(new Course("Matematica",2,"Ecuaciones_lineales_y_cuadraticas"));
            courseRepository.save(new Course("Matematica",2,"Inecuaciones_lineales"));
            courseRepository.save(new Course("Matematica",2,"Geometria"));

            courseRepository.save(new Course("Matematica",3,"Estadistica"));
            courseRepository.save(new Course("Matematica",3,"Sistema_de_ecuaciones_lineales"));
            courseRepository.save(new Course("Matematica",3,"Ecuaciones_e_inecuaciones_lineales"));
            courseRepository.save(new Course("Matematica",3,"Rectas_en_el_plano"));
            courseRepository.save(new Course("Matematica",3,"Funciones"));
            courseRepository.save(new Course("Matematica",3,"Funciones_especiales"));
            courseRepository.save(new Course("Matematica",3,"Funciones_cuadraticas"));
            courseRepository.save(new Course("Matematica",3,"Exponentes_y_logaritmos"));

            courseRepository.save(new Course("Matematica",4,"Funciones"));
            courseRepository.save(new Course("Matematica",4,"Exponenciales"));
            courseRepository.save(new Course("Matematica",4,"Logaritmos"));
            courseRepository.save(new Course("Matematica",4,"Transformaciones_de_graficos"));
            courseRepository.save(new Course("Matematica",4,"Teorema_del_binomio"));
            courseRepository.save(new Course("Matematica",4,"Secuencias_y_series"));
            courseRepository.save(new Course("Matematica",4,"Circulo_unitario_y_la_medida_radial"));
            courseRepository.save(new Course("Matematica",4,"Trigonometria_de_triangulos_no_rectos"));
            courseRepository.save(new Course("Matematica",4,"Funciones_trigonometricas"));
            courseRepository.save(new Course("Matematica",4,"Ecuaciones_trigonometricas_e_identidades"));

            courseRepository.save(new Course("Matematica",5,"Funciones_trigonometricas"));
            courseRepository.save(new Course("Matematica",5,"Ecuaciones_trigonometricas_e_identidades"));
            courseRepository.save(new Course("Matematica",5,"Vectores"));
            courseRepository.save(new Course("Matematica",5,"Aplicaciones_de_vectores"));
            courseRepository.save(new Course("Matematica",5,"Modelacion_lineal"));
            courseRepository.save(new Course("Matematica",5,"Introduccion_al_calculo_diferencial"));
            courseRepository.save(new Course("Matematica",5,"Calculo_integral"));
        };
    }
}


