package com.example.demo;

import com.example.demo.model.Feature;
import com.example.demo.service.FeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class FeatureController {
    private final FeatureService service;

    public FeatureController(FeatureService service) {
        this.service = service;
    }


    @GetMapping("/features")
    @ResponseStatus(HttpStatus.OK)
    List<Feature> getFeature(@RequestParam(name="title", required=false) String title) {
        if(title == null)
            return service.getAll();

        return service.findByTitle(title);
    }


    @GetMapping("/features/{id}")
    @ResponseStatus(HttpStatus.OK)
    Feature getFeature(@PathVariable("id") Integer id) {

        Optional<Feature> feature = service.findById(id);
        if (feature.isEmpty()) {
            throw new FeatureNotFoundException();
        }
        return feature.get();
    }


    //POST /features - For adding a new Feature.
    //    The POST endpoint should return the new Feature with an id assigned to it by the FeatureService.
    @PostMapping("/features")
    @ResponseStatus(HttpStatus.CREATED)
    Feature newFeature(@RequestBody Feature t) {

        return service.add(t);
    }

    //PUT /features/{id} - For updating a particular feature's body or title.
    //    Both the PUT and DELETE endpoints should return a 204 status code upon successful completion of their action.
    //    If there is no resource to be found, only the PUT method should return a 404 status code.

    @PutMapping("/features/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void putFeature(@PathVariable("id") Integer id, @RequestBody Feature t) {

        Optional<Feature> feature = service.findById(id);
        if (feature.isEmpty()) {
            throw new FeatureNotFoundException();
        }

        service.update(t);
    }
    //DELETE /features/{id} - For removing an Feature.

    //    Both the PUT and DELETE endpoints should return a 204 status code upon successful completion of their action.


    @DeleteMapping("/features/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteFeature(@PathVariable("id") Integer id) {
        service.remove(id);
    }


}


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "no feature exists")
class FeatureNotFoundException extends RuntimeException {
}

