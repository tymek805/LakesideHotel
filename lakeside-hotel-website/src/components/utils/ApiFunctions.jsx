import axios from "axios";

export const api = axios.create({
    baseURL : "http://localhost:8080/api/v1/"
})

export async function addRoom(photo, roomType, price) {
    const formData = new FormData()
    formData.append("photo", photo)
    formData.append("roomType", roomType)
    formData.append("price", price)

    const response = await api.post("rooms/add/new-room", formData)
    return response.status === 201
}

export async function getRoomTypes(){
    try {
        const response = await api.get("rooms/room-types")
        return response.data
    } catch (e) {
        throw new Error("Error fetching room types")
    }
}