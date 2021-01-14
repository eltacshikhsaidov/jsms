package co.soft.anonsms.service;

import co.soft.anonsms.entity.Data;
import co.soft.anonsms.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void saveData(Data data) {
        dataRepository.save(data);
    }

    public void deleteData(Long id) {
        dataRepository.deleteById(id);
    }

    public List<Data> allData() {
        return dataRepository.findAll();
    }


}
