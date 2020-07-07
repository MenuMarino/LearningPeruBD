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
        };
    }
}


