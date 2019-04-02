package pl.ls.zaj_26;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MoveController {

    //   @Autowired złe rozwiązanie
    //   private MovieRepository movieRepository;

    private MovieRepository movieRepository;

    public MoveController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @GetMapping("/")
    public String allMovie(Model model) {

        List<Movie> allMovies = movieRepository.findAll();
        model.addAttribute("movies", allMovies);
        return "movies";
    }


    @GetMapping("/infoMovie/{id}")
    public String movieDetalis(Model model, @PathVariable Long id) {

        Optional<Movie> movieOptional = movieRepository.findById(id);

        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            model.addAttribute("movie", movie);
            return "movie";
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("/addmovie")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        TargetAudience[] targetAudiences = TargetAudience.values();
   //     model.addAttribute("targetAudiences" ,targetAudiences);
        return "addMovieForm";
    }

    @PostMapping("/addmovie")
    public String addMovie(Movie movie) {

        movieRepository.save(movie);
        return "redirect:/";
    }

}
