import { unstable_DataStrategyFunction } from "react-router";

export interface BookDto {
    id : number;
    title : string;
    author : string;
    price : number;
    quantity: number;
}

export interface UserDto {
    name: string;
    email: string;
    firstName: string;
    lastName: string;
    country: string;
    currency: string; 
}

export interface UserBookDto{
    book: BookDto;
    user: UserDto;
    quantity: number;
}

export interface CartDto {
    userBookList: UserBookDto[];    
}