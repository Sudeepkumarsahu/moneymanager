package com.sudeep.moneymanager.service;

import com.sudeep.moneymanager.dto.ProfileDTO;
import com.sudeep.moneymanager.entity.ProfileEntity;
import com.sudeep.moneymanager.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileService {

   private final ProfileRepository profileRepository;

   public ProfileDTO registerProfile(ProfileDTO profileDTO){
        ProfileEntity newProfile = toEntity(profileDTO);
        newProfile.setActivationToken(UUID.randomUUID().toString());
        newProfile = profileRepository.save(newProfile);
       return toDTO(newProfile);
   }
   public ProfileEntity toEntity(ProfileDTO profileDTO){
       return ProfileEntity.builder()
               .id(profileDTO.getId())
               .fullName(profileDTO.getFullName())
               .email(profileDTO.getEmail())
               .password(profileDTO.getPassword())
               .createdAt(profileDTO.getCreatedAt())
               .updatedAt(profileDTO.getUpdatedAt())
               .build();
   }

    public ProfileDTO toDTO(ProfileEntity profileEntity){
        return ProfileDTO.builder()
                .id(profileEntity.getId())
                .fullName(profileEntity.getFullName())
                .email(profileEntity.getEmail())
                .createdAt(profileEntity.getCreatedAt())
                .updatedAt(profileEntity.getUpdatedAt())
                .build();
    }
}
