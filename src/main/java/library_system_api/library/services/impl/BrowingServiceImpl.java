package library_system_api.library.services.impl;
import library_system_api.library.models.Browing;
import library_system_api.library.models.Reader;
import library_system_api.library.repositories.BrowingRepository;
import library_system_api.library.services.BrowingService;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class BrowingServiceImpl implements BrowingService {
    private final BrowingRepository browingRepository;

    public BrowingServiceImpl(BrowingRepository browingRepository) {
        this.browingRepository = browingRepository;
    }

    @Override
    public void createBrowing(Browing browing) {
        this.browingRepository.save(browing);
    }

    @Override
    public void updateBrowing(Browing browing) {
        this.browingRepository.save(browing);
    }

    @Override
    public void deleteBrowing(long id) {
        this.browingRepository.deleteById(id);
    }

    @Override
    public Browing getBrowing(long id) {
        return this.browingRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Browing> getAllBrowings() {
        return new HashSet<>(this.browingRepository.findAll());
    }

    @Override
    public Browing getBrowingByReader(Reader reader) {
        return this.browingRepository.findByReader(reader);
    }
}
