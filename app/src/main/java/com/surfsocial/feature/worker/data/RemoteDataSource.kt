package com.surfsocial.feature.worker.data

import com.movacar.data.remote.model.dto.PaginationMemberDTO
import com.surfsocial.common.responses.EmployeeResponse
import com.surfsocial.common.responses.UserInfoResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor() {

    suspend fun getData(page:Int,pageSize:Int) = PaginationMemberDTO<EmployeeResponse>(
         mockWorkers()
    )

    fun mockWorkers()=
        listOf(
            EmployeeResponse(
                userInfo = UserInfoResponse(
                    age = 23,
                    city = "New-York",
                    name="Peta Paka",
                    phone = "420696969"
                ),
                photoUrl = "https://cdn.dribbble" +
                        ".com/users/29574/screenshots/4882066/media/ddbbba6171ecd5b120837e8aa3996b85.png?compress=1&resize=400x300",
                position = "Android Developer",
                skills = listOf("Маркетинг","Figma","Design","Adobe")
            ),
            EmployeeResponse(
                userInfo = UserInfoResponse(
                    age = 23,
                    city = "New-York",
                    name="Peta Paka",
                    phone = "420696969"
                ),
                photoUrl = "https://cdn.dribbble" +
                        ".com/users/29574/screenshots/4882066/media/ddbbba6171ecd5b120837e8aa3996b85.png?compress=1&resize=400x300",
                position = "Android Developer",
                skills = listOf("Маркетинг","Figma","Design","Adobe")
            ),
            EmployeeResponse(
                userInfo = UserInfoResponse(
                    age = 23,
                    city = "New-York",
                    name="Peta Paka",
                    phone = "420696969"
                ),
                photoUrl = "https://cdn.dribbble" +
                        ".com/users/29574/screenshots/4882066/media/ddbbba6171ecd5b120837e8aa3996b85.png?compress=1&resize=400x300",
                position = "Android Developer",
                skills = listOf("Маркетинг","Figma","Design","Adobe")
            ),
            EmployeeResponse(
                userInfo = UserInfoResponse(
                    age = 23,
                    city = "New-York",
                    name="Peta Paka",
                    phone = "420696969"
                ),
                photoUrl = "https://cdn.dribbble" +
                        ".com/users/29574/screenshots/4882066/media/ddbbba6171ecd5b120837e8aa3996b85.png?compress=1&resize=400x300",
                position = "Android Developer",
                skills = listOf("Маркетинг","Figma","Design","Adobe","Маркетинг","Figma","Design","Adobe")
            )
        )
}