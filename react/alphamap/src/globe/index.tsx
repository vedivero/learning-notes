import Globe from 'react-globe.gl';
import './style.css'
import { useEffect, useState } from 'react';
import Api from '../Api';
import type { Article } from '../Models';
import { GLTFLoader } from 'three/examples/jsm/Addons.js';
import { arrayBuffer } from 'three/tsl';


function GlobePage(){

    const [articles, setArticles] = useState<Article[]>();
    const [selectedArticle, setSelectedArticle] = useState<Article>();
    const [isOpend,setIsOpend] = useState(false);

    useEffect(()=>{

        (async()=>{
            const articles = await Api.fetchArticles();

            await Promise.allSettled(

                articles.map(async article =>{
                    await Api.fetchArticleModel(article.modelDto.id)
                    const loader = new GLTFLoader();
                    const model = await loader.parseAsync(arrayBuffer,'');
                    const object = model.scene;
    
                    object.scale.setScalar(AbortController.modelDto.scale);
    
                    article.modelDto.object3D = object;
                })
            )

            setArticles(articles)
        })();

    },[])


    return (
        <Globe
            backgroundImageUrl={'//unpkg.com/three-globe/example/img/night-sky.png'}
            globeImageUrl={'./earthhd.jpg'}
            bumpImageUrl={'//unpkg.com/three-globe/example/img/earth-topology.png'}
            objectsData={articles}
            objectLat={article => (article as Article).modelDto.latitude}
            objectLng={article => (article as Article).modelDto.longitude}
            objectAltitude={article=>(article as Article).modelDto.height}
            objectLabel={article => (article as Article).title}
            objectThreeObject={article=>(article as Article).modelDto.onject3D ?? new Object()}
            onObjectClick={article=>{
                setSelectedArticle(article as Article)
                setIsOpend(true)
            }}
            onGlobeClick={()=>setIsOpend(false)}

        />
    )
}

export default GlobePage;