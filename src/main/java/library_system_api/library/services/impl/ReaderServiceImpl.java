package library_system_api.library.services.impl;
import library_system_api.library.models.Reader;
import library_system_api.library.repositories.ReaderRepository;
import library_system_api.library.services.ReaderService;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class ReaderServiceImpl implements ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public void createReader(Reader reader) {
        this.readerRepository.save(reader);
    }

    @Override
    public void updateReader(Reader reader) {
        this.readerRepository.save(reader);
    }

    @Override
    public void deleteReaderById(long id) {
        this.readerRepository.deleteById(id);
    }

    @Override
    public Reader readReaderById(long id) {
        return this.readerRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Reader> readAllReaders() {
        return new HashSet<>(this.readerRepository.findAll());
    }

    @Override
    public Reader readReaderByEmail(String email) {
        return this.readerRepository.findByEmail(email);
    }
}
