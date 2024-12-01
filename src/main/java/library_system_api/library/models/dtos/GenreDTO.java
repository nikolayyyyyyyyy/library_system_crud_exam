package library_system_api.library.models.dtos;

import library_system_api.library.models.enums.GenreType;

public class GenreDTO {
    private GenreType genreType;

    public GenreDTO() {
    }

    public GenreType getGenreType() {
        return genreType;
    }

    public void setGenreType(GenreType genreType) {
        this.genreType = genreType;
    }
}
