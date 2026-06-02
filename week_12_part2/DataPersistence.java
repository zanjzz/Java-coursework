package week_12_part2;

public class DataPersistence {

    public static void main(String[] args) {

        // Choose storage type 
        DataStorage fileStorage = new FileStorage();
        DataStorage databaseStorage = new DatabaseStorage();
        DataStorage cloudStorage = new CloudStorage();

        // Inject storage into processor 
        DataProcessor fileStorageProcessor = new DataProcessor(fileStorage);
        DataProcessor databaseProcessor = new DataProcessor(databaseStorage);
        DataProcessor cloudStorageProcessor = new DataProcessor(cloudStorage);

        fileStorageProcessor.saveData();
        databaseProcessor.saveData();
        cloudStorageProcessor.saveData();
    }
}

// Handles saving logic without caring where data goes
class DataProcessor {
    DataStorage storage;

    DataProcessor(DataStorage storage) {
        this.storage = storage;
    }

    void saveData() {
        storage.save();
    }
}

// Base contract for all storage types
interface DataStorage {
    void save();
}

// Saves data to a database
class DatabaseStorage implements DataStorage {
    public void save() {
        System.out.println("Data saved in database successfully");
    }
}

// Saves data to a local file
class FileStorage implements DataStorage {
    public void save() {
        System.out.println("File saved successfully");
    }
}

// Saves data to cloud storage
class CloudStorage implements DataStorage {
    public void save() {
        System.out.println("Data saved in cloud storage successfully");
    }
}