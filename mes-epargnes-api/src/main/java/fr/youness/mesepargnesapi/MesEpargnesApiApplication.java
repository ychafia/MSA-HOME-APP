package fr.youness.mesepargnesapi;

import fr.youness.mesepargnesapi.beans.Year;
import fr.youness.mesepargnesapi.dao.EpargneDao;
import fr.youness.mesepargnesapi.dao.YearDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MesEpargnesApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(MesEpargnesApiApplication.class, args);
	}
}
