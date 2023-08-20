package com.github.derickfelix.seatbca.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.derickfelix.seatbca.controllers.dto.request.SpotRequest;
import com.github.derickfelix.seatbca.models.Spot;
import com.github.derickfelix.seatbca.repositories.SpotRepository;

@CrossOrigin
@RestController
@RequestMapping("/spots")
public class SpotController {

  private final SpotRepository repository;

  public SpotController(SpotRepository repository) {
    this.repository = repository;
  }


  @GetMapping
  public List<Spot> findAll() {
    return this.repository.findAll();
  }

  @GetMapping("{id}")
  public Spot findById(@PathVariable Long id) {
    return this.repository.findById(id).orElse(null);
  }

  @PostMapping
  public Spot store(@RequestBody SpotRequest request) {
    if (request.getName() == null) {
      return null;
    }

    return this.repository.save(new Spot(null, request.getName()));
  }

  @PutMapping("{id}")
  public Spot update(@PathVariable Long id, @RequestBody SpotRequest request) {
    Optional<Spot> optional = this.repository.findById(id);

    if (optional.isPresent()) {
      Spot spot = optional.get();
      spot.setName(request.getName());

      return this.repository.save(spot);
    }

    return null;
  }

  @DeleteMapping("{id}")
  public Spot deleteById(@PathVariable Long id) {
    Optional<Spot> optional = repository.findById(id);

    if (optional.isPresent()) {
      repository.deleteById(id);

      return optional.get();
    }

    return null;
  }
}
