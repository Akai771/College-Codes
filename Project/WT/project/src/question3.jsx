// Write a code to build an end-to-end react application on recipe management
// system(SPA)
// - Recipe listing
// - Detailed recipe view
// - Ingredient management
// - Search and filter functionality

import { useState } from 'react';

export default function RecipeManagement() {
    const [recipes, setRecipes] = useState([
        { id: 1, name: 'Pasta', category: 'Italian', ingredients: ['Pasta', 'Tomato Sauce', 'Cheese'], instructions: 'Boil pasta, add sauce, top with cheese.' },
        { id: 2, name: 'Biryani', category: 'Indian', ingredients: ['Rice', 'Chicken', 'Spices'], instructions: 'Cook rice and chicken with spices.' },
        { id: 3, name: 'Burger', category: 'American', ingredients: ['Bun', 'Patty', 'Lettuce', 'Tomato'], instructions: 'Grill patty, assemble burger.' }
    ]);
    
    const [selectedRecipe, setSelectedRecipe] = useState(null);
    const [searchTerm, setSearchTerm] = useState('');
    const [filterCategory, setFilterCategory] = useState('All');
    const [showAddForm, setShowAddForm] = useState(false);

    // Filter recipes based on search and category
    const filteredRecipes = recipes.filter(recipe => {
        const matchesSearch = recipe.name.toLowerCase().includes(searchTerm.toLowerCase());
        const matchesCategory = filterCategory === 'All' || recipe.category === filterCategory;
        return matchesSearch && matchesCategory;
    });

    const categories = ['All', ...new Set(recipes.map(r => r.category))];

    // Delete recipe
    function deleteRecipe(id) {
        setRecipes(recipes.filter(r => r.id !== id));
        if (selectedRecipe?.id === id) setSelectedRecipe(null);
    }

    return (
        <div style={{ padding: '20px' }}>
            <h1>Recipe Management System</h1>
            
            {/* Search and Filter */}
            <div style={{ marginBottom: '20px', display: 'flex', gap: '10px' }}>
                <input
                    type="text"
                    placeholder="Search recipes..."
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                    style={{ padding: '8px', flex: 1 }}
                />
                <select 
                    value={filterCategory} 
                    onChange={(e) => setFilterCategory(e.target.value)}
                    style={{ padding: '8px' }}
                >
                    {categories.map(cat => (
                        <option key={cat} value={cat}>{cat}</option>
                    ))}
                </select>
                <button style={{ padding: '8px 16px' }} disabled>Total Recipes ({filteredRecipes.length})</button>
            </div>

            <div style={{ display: 'flex', gap: '20px' }}>
                {/* Recipe Listing */}
                <div style={{ flex: 1 }}>
                    {filteredRecipes.map(recipe => (
                        <div key={recipe.id} style={{ padding: '15px', marginBottom: '10px', border: '1px solid #ddd', borderRadius: '5px',cursor: 'pointer',backgroundColor: selectedRecipe?.id === recipe.id ? '#e3f2fd' : 'white'}} onClick={() => setSelectedRecipe(recipe)}>
                            <h3 style={{ margin: '0 0 5px 0' }}>{recipe.name}</h3>
                            <p style={{ margin: 0, color: '#666', fontSize: '14px' }}>{recipe.category}</p>
                            <button onClick={(e) => { e.stopPropagation(); deleteRecipe(recipe.id); }}style={{ marginTop: '10px', padding: '5px 10px', backgroundColor: '#ff4444', color: 'white', border: 'none', borderRadius: '3px', cursor: 'pointer' }}>Delete</button>
                        </div>
                    ))}
                </div>

                {/* Detailed Recipe View */}
                <div style={{ flex: 1 }}>
                    {selectedRecipe ? (
                        <div style={{ padding: '10px', border: '1px solid #ddd', borderRadius: '5px'}}>
                            <h2>{selectedRecipe.name}</h2>
                            <div style={{ padding: '10px', border: '1px solid #ddd', borderRadius: '5px', textAlign: 'left' }}>
                                <p><strong>Category:</strong> {selectedRecipe.category}</p>
                                <strong>Ingredients:</strong>
                                <ul>
                                    {selectedRecipe.ingredients.map((ingredient, index) => (
                                        <li key={index}>{ingredient}</li>
                                    ))}
                                </ul>
                                <p><strong>Instructions:</strong> {selectedRecipe.instructions}</p>          
                            </div>
                        </div>
                    ) : (
                        <div style={{ padding: '20px', border: '1px solid #ddd', borderRadius: '5px', textAlign: 'center', color: '#666' }}>
                            <p>Select a recipe to view details</p>
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
}

