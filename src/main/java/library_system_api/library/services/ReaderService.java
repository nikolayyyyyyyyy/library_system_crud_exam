package library_system_api.library.services;

import library_system_api.library.models.Reader;

import java.util.Set;

public interface ReaderService {

    public void createReader(Reader reader);
    public void updateReader(Reader reader);
    public void deleteReaderById(long id);
    public Reader readReaderById(long id);
    public Set<Reader> readAllReaders();
    public Reader readReaderByEmail(String email);
}
