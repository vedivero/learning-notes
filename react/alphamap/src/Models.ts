import type { Object3D } from "three";

export interface Article{
    id: number;
    title: string;
    content: string;
    imgUrl: string;
    modelDto: Model
}

export interface Model{
    id: number;
    filename: string;
    filePath: string;
    latitude: number;
    longitude: number;
    height: number;
    scale:number;
    onject3D?: Object3D;
}

export interface Message{
    message: string;
}