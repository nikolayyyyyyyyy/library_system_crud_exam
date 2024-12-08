package library_system_api.library.services;

import library_system_api.library.models.Browing;
import library_system_api.library.models.Reader;

import java.util.Set;

public interface BrowingService {

    public void createBrowing(Browing browing);
    public void updateBrowing(Browing browing);
    public void deleteBrowing(long id);
    public Browing getBrowing(long id);
    public Set<Browing> getAllBrowings();
    public Browing getBrowingByReader(Reader reader);
}
